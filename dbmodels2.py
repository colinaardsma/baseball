from google.appengine.ext import db

#define columns of database objects
class Users(db.Model):
    username = db.StringProperty(required = True) #sets username to a string and makes it required
    password = db.StringProperty(required = True) #sets password to a string and makes it required
    email = db.StringProperty(required = False) #sets email to a string and makes it optional
    created = db.DateTimeProperty(auto_now_add = True) #sets created to equal date/time of creation (this cannot be modified)
    last_modified = db.DateTimeProperty(auto_now = True) #sets last_modified to equal current date/time (this can be modified)

#define columns of database objects
class fantProProj(db.Model):
    name = db.StringProperty(required = True) #sets title to a string and makes it required
    team = db.StringProperty(required = True) #sets title to a string and makes it required
    pos = db.StringProperty(required = True) #sets title to a string and makes it required
#how to do multiple positions?
    ab = db.IntegerProperty(required = True)
    r = db.IntegerProperty(required = True)
    hr = db.IntegerProperty(required = True)
    rbi = db.IntegerProperty(required = True)
    sb = db.IntegerProperty(required = True)
    avg = db.FloatProperty(required = True)
    obp = db.FloatProperty(required = True)
    h = db.IntegerProperty(required = True)
    double = db.IntegerProperty(required = True)
    triple = db.IntegerProperty(required = True)
    bb = db.IntegerProperty(required = True)
    k = db.IntegerProperty(required = True)
    slg = db.FloatProperty(required = True)
    ops = db.FloatProperty(required = True)
