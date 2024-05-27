pipeline {
    agent any

    tools {
        maven "maven"
        dockerTool "docker"
    }

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/vatsanTraining/spring_may_2024'

                sh "mvn -f /Users/srivatsan/.jenkins/workspace/test/hospital-service/pom.xml -Dmaven.test.failure.ignore=true clean package"
            }
        }
                    stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t vatsank/example-jenkins-build .'
                }
            }
        }

        }
    }




