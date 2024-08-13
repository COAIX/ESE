PREFIX="patientservice"
SUFFIX=$(date +%Y%m%d%H%M%S)
NAME="$PREFIX-$SUFFIX"

docker run -d -p 7071:7071 --network=host --restart=unless-stopped --name "$NAME" patientservice