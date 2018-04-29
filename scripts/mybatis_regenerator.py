import  os

os.system("rm -rf src/main/java/cn/justin/ziwu/server/mybatis/mapper/generated")
os.system("rm -rf src/main/java/cn/justin/ziwu/server/mybatis/model/generated")
os.system("java -jar libs/mybatis-generator-core-1.3.2.jar "
          "-configfile src/main/java/cn/justin/ziwu/server/mybatis/xml/mybatis-generator.xml -overwrite")

# python ./scripts/mybatis_regenerator.py