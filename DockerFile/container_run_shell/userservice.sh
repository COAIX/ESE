PREFIX="userservice"
SUFFIX=$(date +%Y%m%d%H%M%S)
NAME="$PREFIX-$SUFFIX"

docker build -t patientservice /root/patientservice && \
docker build -t appointmentservice /root/appointmentservice && \
docker build -t userservice /root/userservice

docker run -d -p 8081:8081 --network=host --restart=unless-stopped --name "$NAME" userservice
docker run -d -p 7071:7071 --network=host --restart=unless-stopped --name "$NAME" patientservice
docker run -d -p 9091:9091 --network=host --restart=unless-stopped --name "$NAME" appointmentservice