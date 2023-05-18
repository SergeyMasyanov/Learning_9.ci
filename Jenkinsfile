pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                echo 'Compiling'
                echo 'Testing'
                echo 'Packaging'
            }
        }
        stage ('Archive') {
            steps {
                echo 'Archiving'
            }
        }
        stage ('Deploy') {
            steps {
                echo 'Deploying'
            }
        }
    }
}