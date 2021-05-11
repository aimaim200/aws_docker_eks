pipeline{
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages{
        stage('Building Pipeline'){
            step{
                echo '=== Building The pipeline ==='
                url 'wwww.github.com/aimaim2000/enee'
            }
        }
        stage('Testing Pipeline'){
            step{
                echo '=== Testing Junit ==='
                sh 'mvn test'
               
                post {
                    always {
                        Junit 'path/*.xml'
                    }
                }
                
            }
        }
        stage('Build Docker Image'){
            when {
                branch 'master'
            }
            steps{
                echo '=== Building Docker Image ==='
                script {
                    app = docker.build(' ')
                }
            }
        }
        stage('Pushing Docker Image'){
            when {
                branch 'master'
            }
            steps{
                echo '=== Pushing Docker Image ==='
                script{

                }
            }

        }
        stage('Remove Local Docker Image'){
            steps{
                script{
                    echo '=== Remove Local Image'
                }
            }
           
        }
    }
}