pipeline {
    agent any

    tools {
        maven "maven"
    }

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/vatsanTraining/spring_may_2024'

                sh "mvn -f /Users/srivatsan/.jenkins/workspace/test/pom.xml" -Dmaven.test.failure.ignore=true clean package"

            }

        
        }
    }
}
