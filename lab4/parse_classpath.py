import xml.etree.ElementTree as ET

tree = ET.parse('.classpath')
root = tree.getroot()

classpath = ":".join(entry.get("path") for entry in root.findall(".//classpathentry[@kind='lib']")) + ":bin"
print(classpath)
