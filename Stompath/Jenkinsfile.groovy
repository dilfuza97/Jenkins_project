node{
    stage("Update jenkins"){
        properties([parameters([string(defaultValue: '34.247.186.166', description: 'Please provide IP', name: 'ENVIR', trim: true)])])
        sh "echo Parameter added"
    }
    stage("Install git"){
        sh "ssh  ec2-user@${ENVIR} sudo yum install git python-pip -y"
    }
    stage("Remove repo"){
        def exists = fileExists 'stormpath-flask-sample'
        if (exists) {
            echo "exists"
        } else {
        }
    }
    stage("Pull Repo"){
        sh "ssh  ec2-user@${ENVIR} git clone https://github.com/dilfuza97/stormpath-flask-sample.git 2. /dev/null"
    }
    stage("Install Requirements"){
        sh "echo Hello"
    }
    stage("Pip Install"){
        sh "ssh  ec2-user@${ENVIR} sudo pip install -r /home/ec2-user/stormpath-flask-sample/requirements.txt"
    }
    stage("Run App"){
        sh "ssh  ec2-user@${ENVIR}  python /home/ec2-user/stormpath-flask-sample/bootstrap.py"
    }
}
