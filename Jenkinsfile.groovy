pipeline {
    agent any
    tools {
        maven 'MAVEN_3_6_3'
        jdk 'JDK-17'
    }
    stages {
        stage ('Compile Stage 2023-2') {
            steps {
                withMaven(maven : 'MAVEN_3_6_3') {
                    bat 'mvn clean compile'
                }
            }
        }
        stage ('Testing Stage 2023-2') {
            steps {
                withMaven(maven : 'MAVEN_3_6_3') {
                    bat 'mvn test'
                }
            }
        }

        stage ('package Stage 2023-2') {
            steps {
                withMaven(maven : 'MAVEN_3_6_3') {
                    bat 'mvn package'
                }
            }
        }
    }
}