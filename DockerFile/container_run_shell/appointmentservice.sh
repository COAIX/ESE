PREFIX="appointmentservice"
SUFFIX=$(date +%Y%m%d%H%M%S)
NAME="$PREFIX-$SUFFIX"

docker run -d -p 9091:9091 --network=host --restart=unless-stopped --name "$NAME" appointmentservice