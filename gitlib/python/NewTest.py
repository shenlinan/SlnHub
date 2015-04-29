
#coding=utf-8
'''
Created on 2015年4月29日

@author: Administrator
'''

names =['yanzhu','zaizhu','mingzhu']
for name in names:
    print name
    
sum=0
for x in range(101):
    sum = sum + x
print sum


d={'yaozhu':59,'zaizhu':66,'mingzhu':99}
print d['yaozhu']

e={'tom':22,'jery':33}
e['tom']=11
print e['tom']

def area_of_circle(x):
    return 3.14*x*x
s = area_of_circle(2)
print s


def calc(numbers):
    sum = 0
    for n in numbers:
        sum = sum + n * n
    return sum
print 'calc:'
print calc([1,2])


def func(a,b,c=0,*args,**kw):
    print 'a=',a,'b=',b,'c=',c,'args=',args,'kw=',kw
    
a=[1,2,3,4,5]
b={'city':'nanjing','age':22}
func(2,3,*a,**b)

print a[0:3]

for k,v in d.iteritems():
    print k,':',v
    
for i,v in enumerate(a):
    print i,v


print [x*x for x in range(1,10)]


newList = ['Hello','World']
print [s.lower() for s in newList]
