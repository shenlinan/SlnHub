s=['tom','zaiZhu','YAOZHU']
def initName(name):
    return map(name[0].upper+name[1:].lower)
print initName(s)