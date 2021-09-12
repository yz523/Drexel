import sys
from multiprocessing import Pool
import numpy as np

def getValByKey(row, col):
    global header
    result = ''
    idx = 0
    
    for keycol in header.split(','):
        if keycol == col:
            result = row.split(',')[idx]
            break
        idx = idx + 1

    result = result.strip().replace('\'', '')
    return result

def mapper1(process_data):
    result = dict()
    for row in process_data:
        arp = getValByKey(row, 'Origin')
        key = arp
        if not (key in result):
            result[key] = []
        
        wea = getValByKey(row, 'WeatherDelay')
        if (wea != ''):
            weaint = int(float(wea))
        else:
            weaint = 0
        
        sec = getValByKey(row, 'SecurityDelay')
        if (sec != ''):
            secint = int(float(sec))
        else:
            secint = 0
        wasint = weaint + secint

        lad = getValByKey(row, 'LateAircraftDelay\r\n')
        if (lad != ''):
            ladint = int(float(lad))
        else:
            ladint = 0
        val = str(wasint)+ "_" + str(ladint)
        result[key].append(val)
        #return result
    return result

def mapper2(process_data):
    result = dict()
    for row in process_data:
        car = getValByKey(row, 'UniqueCarrier')
        key = car
        if not (key in result):
            result[key] = []
        
        crd = getValByKey(row, 'CarrierDelay')
        if (crd != ''):
            crdint = int(float(crd))
        else:
            crdint = 0
        
        lad = getValByKey(row, 'LateAircraftDelay\r\n')
        if (lad != ''):
            ladint = int(float(lad))
        else:
            ladint = 0
        val = str(crdint)+ "_" + str(ladint)
        result[key].append(val)
    #return result
    return result



def partition(mappings_list):
    result = dict()
    for mappings in mappings_list:
        for key in mappings:
            for val in mappings[key]:
                if not (key in result):
                    result[key] = []
                
                result[key].append(val)

    return result

def reducer1(tuple_list):
    cbnres = dict()
    for tuple in tuple_list:
        #city_country = tuple[0]
        arp = tuple_list[0]
        #rows = tuple[1]
        rows = tuple_list[1]
        
        if not (arp in cbnres):
            cbnres[arp] = 0
            for row in rows:
                element = row.split('_')
                cbn = element[0]
                cbnres[arp] = cbnres[arp] + int(cbn)
    return cbnres


def reducer3(tuple_list):
    ladres = dict()
    for tuple in tuple_list:
        #city_country = tuple[0]
        arp = tuple_list[0]
        #rows = tuple[1]
        rows = tuple_list[1]

        if not (arp in ladres):
            ladres[arp] = 0
            for row in rows:
                element = row.split('_')
                lad = element[1]
                ladres[arp] = ladres[arp] + int(lad)
    return ladres

filename = sys.argv[1]
processes = int(sys.argv[2])
header = ''

csvlines = []
csvfile = open(filename, 'r')
lineno = 0

for line in csvfile:
    if lineno > 0:
        csvlines.append(line)
    else:
        header = line
    lineno = lineno + 1

numlines = len(csvlines)
lines_per_process = numlines / processes

process_data_array = []
for i in range(processes):
    start = i * (numlines / processes)
    end = (i+1) * (numlines / processes)
    process_data_array.append(csvlines[start:end])

pool = Pool(processes=processes,)

mapping1 = pool.map(mapper1, process_data_array)
shuffled1 = partition(mapping1)
reduced1 = pool.map(reducer1, shuffled1.items())
reduced3 = pool.map(reducer3, shuffled1.items())
mapping2 = pool.map(mapper2, process_data_array)
shuffled2 = partition(mapping2)
reduced2 = pool.map(reducer1, shuffled2.items())
reduced4 = pool.map(reducer3,shuffled2.items())

arpcounter = 0
totaldelay = 0
max = 0
res = ''
for i in reduced1:
    for j in i:
        if(int(float(i[j]))>max):
            max = int(float(i[j]))
            res = j
print "The airport had the longest delays due to security and weather (combined) is:",res

for i in reduced2:
    for j in i:
        if(int(float(i[j]))>max):
            max = int(float(i[j]))
            res = j
print "The carrier had the longest delays due to carrier delays is:",res

for i in reduced3:
    for j in i:
        totaldelay = totaldelay + int(float(i[j]))
        arpcounter = arpcounter + 1
print "The the average total late aircraft delay for each airport is:",totaldelay/arpcounter

arpcounter = 0
carcounter = 0
totaldelay = 0

for i in reduced4:
    for j in i:
        totaldelay = totaldelay + int(float(i[j]))
        carcounter = carcounter + 1
print "The the average total late aircraft delay for each carrier is:",totaldelay/carcounter
