echo "Please enter the path"
read path
lastChar=${path: -1}
subPath='wso2telcohub-2.0.0/repository/deployment/server/synapse-configs/default/api/'
if [ $lastChar == "/" ]
then
	realPath=$path$subPath
else
	realPath=$path'/'$subPath
fi
XMLPath=$realPath'*.xml'
if [ -d $realPath ] 
then
	for filename in $XMLPath; do
		val=$(awk '/MifeInternalAPIResponseHandler/{ print NR; }' $filename)
		a='d'
		if [ -n "$val" ]
		then
			sed --in-place $val$a $filename
		fi
	done
else
    echo "$realPath does not exist."
fi



