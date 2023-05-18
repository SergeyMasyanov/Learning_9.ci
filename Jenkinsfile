pipeline {
    agent any

    triggers {
        pollSCM ('* * * * *') // опрос репозитория на изменения каждую минуту
    }

    stages {
        stage ('Build') {
            steps {
                bat 'mvn clean package' // собираем проект
            }
            post {  // после основных шагов
                success { // если предыдущие шаги успешны
                    echo 'Archiving artifact...'
                    archiveArtifacts artifacts: '**/target/*war', followSymlinks: false
                }
            }
        }
        stage ('Deploy to test & checkstyle') {
            parallel {  // параллельное исполнение jobов
                stage ('Checkstyle') {  // проверка кода
                     steps {
                        bat 'mvn checkstyle:checkstyle'
                     }
                     post {  // после основных шагов
                        success { // если предыдущие шаги успешны
                            echo 'Publishing checkstyle results.'
                            checkstyle canComputeNew: false, defaultEncoding: ", healthy: ", pattern: ",unHealthy:"
                        }
                     }
                }
            }
                }
                stage ('Deploy to test environment') {  // копируем приложения в другую директорию
                    steps {
                        bat "xcopy /a/y webapp\\target\\webapp.war D:\apache-tomcat-9.0.75 production\\env_test\\webapps"
                    }
                }
            }
        }
        stage ('Deploy to production') {  // развертывание в продакшене
            steps { // ручное подтверждение команды
                timeout(time: 2, unit: 'DAYS') { // устанавливаем таймаут на действие
                    input message: 'Deploy to production?', submitter: 'admin'
                }
                bat "xcopy /a/y webapp\\target\\webapp.war D:\apache-tomcat-9.0.75 production\\env_prod\\webapps"
            }
        }
    }
}