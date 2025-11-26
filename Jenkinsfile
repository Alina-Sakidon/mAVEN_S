pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'maven'
    }

    stages {
        stage('Run TestNG suite') {
            steps {
                sh 'mvn clean test "-Dsurefire.suiteXmlFiles=src/test/resources/asakidon.xml"'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}
