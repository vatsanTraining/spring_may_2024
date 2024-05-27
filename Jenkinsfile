pipeline {
    agent any

    tools {
        maven "maven"
    }

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/vatsanTraining/spring_may_2024'

                sh "mvn -Dmaven.test.failure.ignore=true clean package"

            }

            
        }
    }
}
