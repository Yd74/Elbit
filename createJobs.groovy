import javaposse.jobdsl.dsl.DslFactory

job('get_containers') {
    scm {
        git('https://github.com/Yd74/Elbit.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Yarin Dolev')
            node / gitConfigEmail('yarshar7474@gmail.com')
        }
    }

    steps {
        dir('get_containers')
        dockerBuildAndPublish {
            repositoryName('yarshar/getcontainers')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}

job('nginx') {
    scm {
        git('https://github.com/Yd74/Elbit.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Yarin Dolev')
            node / gitConfigEmail('yarshar7474@gmail.com')
        }
    }

    steps {
        dir('nginx_proxy_to_get_container')
        dockerBuildAndPublish {
            repositoryName('yarshar/nginxproxytogetcontainer')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}