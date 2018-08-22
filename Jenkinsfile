pipeline {
    agent {
    node(){
        git credentialsId: '4afb391b-c0f9-4a16-bd14-774af3138070', url: 'https://github.com/paramvir-boparai/sample-app.git', poll: true 
    }
    }
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
                        bat "mvn test"
                     }
                }, sonar: {
                    withMaven(maven: 'Maven') {
                        bat "mvn sonar:sonar -Dsonar.host.url=http://172.19.223.209:9000"    
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
                    bat 'echo qa deploy' 
                }
            }
        }
        stage('QA Regression') { 
            steps {
                bat 'echo qa Regression' 
            }
        }
        stage('QA Security Testing') { 
            steps {
                 withMaven(maven: 'Maven') {
                    bat 'echo qa Security Testing' 
                }
            }
        }
        stage('PROD') { 
            steps {
                withMaven(maven: 'Maven') {
                    bat 'echo prod' 
                }
            }
        }
        stage('PROD Regression') { 
            steps {
                 withMaven(maven: 'Maven') {
                    bat 'echo prod Regression' 
                }
            }
        }
    }
}

