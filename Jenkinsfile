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
                        bat "mvn test"
                     }
                }, sonar: {
                    withMaven(maven: 'Maven') {
                        bat 'echo sonar skipped'  
                    }
                    
                })
            }
           
        }
        stage('Deploy to INT env') { 
            steps {
                withMaven(maven: 'Maven') {
                    bat 'echo int' 
                }
            }
        }
        stage('Deploy to QA env') { 
            input {
               message "Are you sure and wanna proceed with QA Deployment?"
           }
            steps {
                withMaven(maven: 'Maven') {
                    bat 'echo qa deploy' 
                }
            }
        }
        stage('Run QA Regression suite') { 
            steps {
                bat 'echo qa Regression' 
            }
        }
        stage('Run QA Security Testing Suite') { 
            steps {
                 withMaven(maven: 'Maven') {
                    bat 'echo qa Security Testing' 
                }
            }
        }
        stage('Deploy to PROD env') { 
            steps {
                withMaven(maven: 'Maven') {
                    bat 'echo prod' 
                }
            }
        }
        stage('Run PROD Regression Suite') { 
            steps {
                 withMaven(maven: 'Maven') {
                    bat 'echo prod Regression' 
                }
            }
        }
    }
    
     post {
        failure {
            script {
                currentBuild.result = 'FAILURE'
            }
        }

        always {
            emailext body: 'Build Success', 
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], 
                                     [$class: 'RequesterRecipientProvider']], 
                subject: 'Build Success', to: 'paramvir.boparai@globallogic.com'
        }
    }
}

