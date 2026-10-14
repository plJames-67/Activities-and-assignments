message = "Hello Python"
byte_obj = bytes(message, 'utf-8')
print("Bytes object: ", byte_obj)
print("Bytes to string: ", str(byte_obj, encoding= 'ascii', errors='ignore') )
byte_obj = byte_obj.hex()
print("Bytes to hex: ", byte_obj)
byte_obj = bytes.fromhex(byte_obj)
print("Hex to bytes: ", byte_obj)
byte_array = bytearray(byte_obj)
print("New bytearray: ",byte_array )
byte_objarray = bytearray(byte_obj)
print("Bytes to bytearray: ", byte_objarray )
print("Sliced bytes: ", byte_obj[5:])
byte_objarray[0] = 104 
print("Modified message: ", byte_objarray)


