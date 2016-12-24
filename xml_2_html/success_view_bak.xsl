<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
			<title><xsl:value-of select="view/header/title"/></title>
			</head>
			<body>

					
						<xsl:element name="form">  
							<xsl:attribute name="name"><xsl:value-of select="./view/body/form/name"/></xsl:attribute>
							<xsl:attribute name="action"><xsl:value-of select="./view/body/form/action"/></xsl:attribute>
							<xsl:attribute name="method"><xsl:value-of select="./view/body/form/method"/></xsl:attribute>
		
							<xsl:for-each select="./view/body/form/textView">
								<br/>
								<xsl:value-of select="lable"/>
								<xsl:element name="input"> 
									<xsl:attribute name="type">text</xsl:attribute>
									<xsl:attribute name="name"><xsl:value-of select="name"/></xsl:attribute>
									<xsl:attribute name="value"><xsl:value-of select="value"/></xsl:attribute>
								</xsl:element>
							</xsl:for-each>
	
							<xsl:for-each select="./view/body/form/buttonView">
								<br/>
								<xsl:value-of select="lable"/>
								<xsl:element name="input"> 
									<xsl:attribute name="type">button</xsl:attribute>
									<xsl:attribute name="name"><xsl:value-of select="name"/></xsl:attribute>
								</xsl:element>
							</xsl:for-each>
						</xsl:element>

			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>