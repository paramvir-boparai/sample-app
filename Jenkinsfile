pipeline {
    agent any
    
    stages {
        stage('Package') {
            steps {
               withMaven(maven: 'Maven') {
                    bat 'mvn clean package'
                }
            }
        }
      stage('test') {
            steps {
                parallel(test: {
                     withMaven(maven: 'Maven') {
                        bat "mvn -U clean test cobertura:cobertura -Dcobertura.report.format=xml"
                     }
                }, sonar: {
                    withMaven(maven: 'Maven') {
                        bat "mvn sonar:sonar -Dsonar.host.url=${env.SONARQUBE_HOST}"    
                    }
                    
                })
            }
           
        }
        stage('INT') { 
            steps {
                withMaven(maven: 'Maven') {
                    bat 'echo int' 
                }
            }
        }
        stage('QA') { 
            input {
               message "Are you sure and wanna proceed with QA Deployment?"
           }
            steps {
                withMaven(maven: 'Maven') {
                    shell 'echo qa deploy' 
                }
            }
        }
        stage('QA Regression') { 
            steps {
                shell 'echo qa Regression' 
            }
        }
        stage('QA Security Testing') { 
            steps {
                 withMaven(maven: 'Maven') {
                    shell 'echo qa Security Testing' 
                }
            }
        }
        stage('PROD') { 
            steps {
                withMaven(maven: 'Maven') {
                    shell 'echo prod' 
                }
            }
        }
        stage('PROD Regression') { 
            steps {
                 withMaven(maven: 'Maven') {
                    shell 'echo prod Regression' 
                }
            }
        }
    }
}

