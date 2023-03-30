FROM docker.io/yjqg6666/alpine-jdk8:8u322-target-app

ENV APP_NAME=demo-web

USER root

ARG JAR_RPATH
