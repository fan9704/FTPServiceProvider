# Technical Support

### Docker Support

1. [Docker pure-ftpd](https://blog.clarence.tw/2022/04/10/docker-%E4%BD%BF%E7%94%A8-pure-ftpd-%E5%95%9F%E5%8B%95-ftp-server/)
2. 
### Docker Command Support
###### Check container Environment
```shell
docker inspect <Container Name>
```

```shell
docker ps -a --no-trunc | grep <Container Name>
```

```shell
#Through Python to Inspect
pip install runlike
runlike -p <Container Name>
```