import javaposse.jobdsl.dsl.DslFactory

job('get_containers') {
    scm {
        git('https://github.com/Yd74/Elbit.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Yarin Dolev')
            node / gitConfigEmail('yarshar7474@gmail.com')
        }
    }

    dir('get_containers')

    steps {
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

    dir('nginx_proxy_to_get_container')

    steps {
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