FROM node:carbon
WORKDIR /usr/src/app

RUN apt-get update && \
    apt-get install -y python && \
    apt-get install -y python-pip  && \
    apt-get upgrade -y && \
    apt-get install -y  software-properties-common && \
    add-apt-repository ppa:webupd8team/java -y && \
    echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
    apt-get install -y oracle-java7-installer && \
    apt-get clean
RUN pip install pygments
COPY package*.json ./
RUN npm install
COPY bower.json ./
RUN bower install
COPY api ./
COPY www ./
COPY storage ./
COPY RES.jar ./
COPY com ./
COPY RunConfig.properties ./
COPY . .
EXPOSE 3000
CMD [ "npm", "start" ]