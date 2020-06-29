#!/bin/bash
copyFilesToTemp(){
mkdir -p $jagAppsDir/${2}


echo .$1' .updated []'
jq -r .$1' .updated []'  $customizedList |
while IFS= read -r paths ; do
    nativeFilePath=$(echo $paths | cut -d'/' -f 7-)

    DirNameFile=$(dirname "${jagAppsDir}/${2}/${nativeFilePath}")
    echo "$DirNameFile"
    echo "${jagAppsDir}/${2}/${nativeFilePath}"

    mkdir -p $DirNameFile  && cp -r ${jagAppsDir}/${1}/${nativeFilePath}  $DirNameFile

done
return 10
}

replaceModule(){
rm -rf $jagAppsDir/${1}
mv $jagAppsDir/${2} $jagAppsDir/${1}
return 10
}

createTempDir(){
mkdir -p $jagAppsDir/${1}
mkdir -p $jagAppsDir/${2}
return 10
}


cd ../../
customizedList=$(pwd)/modules/wum-profile/wumscript/customizedList.json
jagAppsDir=$(pwd)/modules/p2-profile/product/target/features/jaggeryapps


echo "Script Starting --- "
apt-get install jq -y
createTempDir 'publisher-temp' 'store-temp'
copyFilesToTemp 'store' 'store-temp'
copyFilesToTemp 'publisher' 'publisher-temp'
replaceModule 'store' 'store-temp'
replaceModule 'publisher' 'publisher-temp'
echo "done ---"





