<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
			<head>
				<title><xsl:value-of select="view/header/title"/></title>
			</head>
			<body>
			<xsl:apply-templates select="view/body" /> 
			</body>
		</html>
	</xsl:template>

	<xsl:template match = "body">
		<xsl:for-each select="form">
			<xsl:element name="form">  
				<xsl:attribute name="name"><xsl:value-of select="name"/></xsl:attribute>
				<xsl:attribute name="action"><xsl:value-of select="action"/></xsl:attribute>
				<xsl:attribute name="method"><xsl:value-of select="method"/></xsl:attribute>
				
				
					<xsl:for-each select="textView">
							<br/>
							<xsl:value-of select="lable"/> : <xsl:element name="input"> 
								<xsl:attribute name="type">text</xsl:attribute>
								<xsl:attribute name="name"><xsl:value-of select="name"/></xsl:attribute>
								<xsl:attribute name="value"><xsl:value-of select="value"/></xsl:attribute>
							</xsl:element>
					</xsl:for-each>
				
		
				
					<xsl:for-each select="buttonView">
						<br/>
						<xsl:value-of select="lable"/> : <xsl:element name="input"> 
							<xsl:attribute name="type">button</xsl:attribute>
							<xsl:attribute name="name"><xsl:value-of select="name"/></xsl:attribute>
						</xsl:element>
					</xsl:for-each>
				
			</xsl:element>
		</xsl:for-each>	
	</xsl:template>


</xsl:stylesheet>