job('ElbitTest') {
    scm {
        git('https://github.com/Yd74/Elbit.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Yarin Dolev')
            node / gitConfigEmail('yarshar7474@gmail.com')
        }
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('yarshar/dolevyarin')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}