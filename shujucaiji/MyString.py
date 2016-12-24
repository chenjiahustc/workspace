class MyString(object):
    def string_to_integer(self, str):
        result=0
        decimal=0
        if(str!=''):
            i=0
            while(i<len(str)):
                if(str[i:i+1]>="0" and str[i:i+1]<="9"):
                    result*=10
                    result+=int(str[i:i+1])
                elif(str[i:i+1]=="," or str[i:i+1]=="£¬"):
                    pass
                elif(str[i:i+1]=="Íò"):
                    result*=10000
                elif(str[i:i+1]=="."):
                    i+=1
                    j=0
                    while(i<len(str)):
                        if(str[i:i+1]>="0" and str[i:i+1]<="9"):
                            j+=1
                            decimal*=10
                            decimal+=int(str[i:i+1])
                        elif(str[i:i+1]=="Íò"):
                            result*=10000
                            decimal*=10000
                            while(j>0):
                                decimal/=10
                                j-=1
                            return result+int(decimal)
                        else:
                            pass
                        i+=1
                else:
                    pass
                i+=1
        return result

#²âÊÔ´úÂë
'''
print(MyString.string_to_integer("°¢É­ËÉµº1,2f34Íò"))
'''