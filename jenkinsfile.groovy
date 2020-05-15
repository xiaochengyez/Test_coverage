stage('pull source code') {
    node('master'){
        git([url: 'git@github.com:xiaochengyez/Test_coverage.git', branch: 'master'])
    }
}

stage('maven compile & package & code review') {
    node('master'){
        sh "clean verify sonar:sonar-Dsonar.host.url=http://ip:9000 -Dsonar.login=$token"
    }
}

stage('start service') {
    node('master'){
        try{
            sh 'java -javaagent:org.jacoco.agent-runtime.jar=output=tcpserver,address=0.0.0.0,port=6300 -jar spring.jar '
        }catch(exc){
            echo 'start service fail!'
        }

    }
}

stage('create jacoco.exec') {
    node('master'){
        try{
            sh 'java -jar org.jacoco.cli-nodeps.jar dump --address=0.0.0.0 --port 6300 --destfile=jacoco.exec --reset'
        }catch(exc){
            echo 'create jacoco.exec fail'
        }
    }
}

stage('html coverage') {
    node('master'){
        try{
            sh 'java -jar org.jacoco.cli-nodeps.jar report jacoco.exec --classfiles /home/jenkins/workspace/spring_jacoco/target/classes/ --sourcefiles /home/jenkins/workspace/spring_jacoco/src/main/java --html coverage'
        }catch(exc){
            echo 'html coverage fail!'
        }
    }
}