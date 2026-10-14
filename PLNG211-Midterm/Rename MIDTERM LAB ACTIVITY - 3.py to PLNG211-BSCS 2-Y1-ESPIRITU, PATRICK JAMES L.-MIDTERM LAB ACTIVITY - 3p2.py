
first_name = input("Enter First Name:")
last_name = input("Enter Last name:")
print("First name: " , first_name)
print("Last name: " , last_name)

full_name = first_name + " " +last_name
print("Full name: ", full_name)

first_char = full_name[0]
last_char = full_name[-1]
print("First character: ", first_char)
print("Last character: ", last_char)

try:
   first_name[0] = "D" 
except:
    print("Strings are immutable; individual characters \ncannot be changed directly.")

print("New name: ", "D" + first_name[1:])
print("Old name: ", first_name)

print("Characters in full name: ")
for i in range(len(full_name)):
    print(full_name[i])

split = full_name.split()
print("Sliced First Name: ", split[0])
print("Sliced Last Name: ", full_name[1])

char_search = input("Enter one character to search: ")

if len(char_search) != 1:
    print("Error: Please enter exactly one character.")
else:
    if char_search in full_name:
        index = full_name.find(char_search)
        print(f"Success! The character '{char_search}' was found at index {index}.")
    else:
        print("the character is nowhere to be found.")


