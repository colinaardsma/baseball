import urllib, urllib2, os, webapp2, math, re #import stock python methods (re is regular expersions)
import jinja2 #need to install jinja2 (not stock)
from xml.dom import minidom
import json

#setup jinja2
template_dir = os.path.join(os.path.dirname(__file__), 'templates') #set template_dir to main.py dir(current dir)/templates
jinja_env = jinja2.Environment(loader = jinja2.FileSystemLoader(template_dir),
                               autoescape = True) #set jinja2's working directory to template_dir

#define some functions that will be used by all pages
class Handler(webapp2.RequestHandler):
    def write(self, *a, **kw): #simplifies self.response.out.write to self.write
        self.response.out.write(*a, **kw)

    def render_str(self, template, **params): #creates the string that will render html using jinja2 with html template named template and parameters named params
        t = jinja_env.get_template(template)
        return t.render(params)

    def render(self, template, **kw): #writes the html string created in render_str to the page
        self.write(self.render_str(template, **kw))

    # def initialize(self, *a, **kw):
    #     """
    #         A filter to restrict access to certain pages when not logged in.
    #         If the request path is in the global auth_paths list, then the user
    #         must be signed in to access the path/resource.
    #     """
    #     webapp2.RequestHandler.initialize(self, *a, **kw)
    #     c = self.request.cookies.get('user') #pull cookie value
    #     uid = ""
    #     if c:
    #         uid = hashing.check_secure_val(c)
    #
    #     self.user = uid and Users.get_by_id(int(uid))
    #
    #     if not self.user and self.request.path in auth_paths:
    #         self.redirect('/login')


# class Index(Handler): #xml parsing
#     def render_index(self):
#         p = urllib2.urlopen("http://www.nytimes.com/services/xml/rss/nyt/GlobalHome.xml") #create a file object of the url
#         r = p.read() #read the contents of the file (either html or xml data)
#         c = minidom.parseString(r) #parse the raw xml data through minidom xml parser (doing this allows for more data manipulation later)
#         d = dir(c) #list the methods available to run on the data
#         h = c.toprettyxml() #convert the parsed wall of text into something readable
#         t = c.getElementsByTagName('item') #pull all elements by tag name
#         s = len(t) #count elements gathered in t
#         self.render("index.html", p=p, d=d, h=h, s=s)
#
#     def get(self):
#         self.render_index()

class Index(Handler): #json parsing
    def render_index(self):
        j = r'{"one": 1, "numbers": [1,2,3.5], "one": 2}' #r means raw and escapes any \ included
        c = json.loads(j)
        d = c['numbers']
        h = c['one']


        self.render("index.html", p=j, c=c, d=d, h=h, s=j)

    def get(self):
        self.render_index()

# class Index(Handler): #html parsing
#     def render_index(self):
#         url = urllib2.urlopen("http://www.fangraphs.com/projections.aspx?pos=all&stats=bat&type=steamer") #create a file object of the url
#         content = url.read() #read the contents of the file (either html or xml data)
#         parsedContent = minidom.parseString(content) #MINIDOM DOESNT WORK WITH HTML OR XHTML
#         methods = dir(parsedContent) #list the methods available to run on the data
#         pretty = parsedContent.toprettyxml()
#         players = parsedContent.getElementsByTagName('tr')
#         self.render("index.html", p=url, c=content, d=parsedContent, h=pretty, s=players)
#
#     def get(self):
#         self.render_index()



app = webapp2.WSGIApplication([
    ('/', Index)
    # webapp2.Route('/user/<u:[a-zA-Z0-9_-]{3,20}>', PostList),
    # ('/archive', Archive),
    # ('/new_post', NewPost),
    # ('/modify_post', ModifyPost),
    # webapp2.Route('/post/<post_id:\d+>', ViewPost),
    # webapp2.Route('/post/<post_id:\d+>/edit', EditPost),
    # webapp2.Route('/post/<post_id:\d+>/delete', DeletePost),
    # ('/registration', Registration),
    # ('/login', Login),
    # ('/logout', Logout),
    # ('/welcome', Welcome)
], debug=True)
