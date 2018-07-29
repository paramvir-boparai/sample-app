pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    sh 'mvn sonar:sonar'
            }
        }
        stage('INT') { 
            steps {
                sh 'echo int' 
            }
        }
        stage('QA') { 
            steps {
                sh 'echo qa' 
            }
        }
        stage('QA Regression') { 
            steps {
                sh 'echo qa Regression' 
            }
        }
        stage('QA Security Testing') { 
            steps {
                sh 'echo qa Security Testing' 
            }
        }
        stage('PROD') { 
            steps {
                sh 'echo prod' 
            }
        }
        stage('PROD Regression') { 
            steps {
                sh 'echo prod Regression' 
            }
        }
    }
}
