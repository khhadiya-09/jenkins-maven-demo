
pipeline {
    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven-3.10.0'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn -B clean package'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'tomcat-creds',
                    usernameVariable: 'TOMCAT_USER',
                    passwordVariable: 'TOMCAT_PASS'
                )]) {
                    bat '''
                    curl.exe --fail --show-error --silent ^
                    -u "%TOMCAT_USER%:%TOMCAT_PASS%" ^
                    -T "target\\jenkins-maven-demo-1.0-SNAPSHOT.war" ^
                    "http://localhost:7080/manager/text/deploy?path=/jenkins-maven-demo&update=true"
                    '''
                }
            }
        }
    }
}
