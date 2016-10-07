import urllib2
from dbmodels import Users, Blog #import Users and Blog classes from python file named dbmodels
import hashing, gqlqueries, validuser #import python files I've made
from xml.dom import minidom


import sys
sys.path.insert(0, 'libs')
import lxml.html



# from bs4 import BeautifulSoup
# import lxml.html
# import requests
# from lxml import *


def pull_data(url):

#     code   = urllib.urlopen("http://www.example.com/page.html").read()
# html   = lxml.html.fromstring(code)
# result = html.xpath('//td[@class="test"][position() = 1 or position() = 4]')

    # content = urllib2.urlopen(url).read()
    # page = requests.get(url)
    # tree = lxml.html.fromstring(content)
    # name = tree.xpath('//a[@class="player-name"]/text()')


    # content = None
    # try:
    #     content = urllib2.urlopen(url).read()
    # except urllib2.URLError:
    #     return
    #
    # results = {}
    #
    # if content:
    #     bs = BeautifulSoup(content, 'html.parser')
    #
    #     for row in bs.findAll('tr'):
    #         aux = row.findAll('td')
    #         results[aux[0].string] = aux[1].string

    return url
