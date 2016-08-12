import webapp2
import random

class Index(webapp2.RequestHandler):

    def getRandomMovie(self):

        # TODO: make a list with at least 5 movie titles
        movies = ["The Big Lebowski", "Rogue One", "Big", "Frozen", "Wall-E"]

        # TODO: randomly choose one of the movies, and return it
        movieChoice = random.choice(movies)

        return movieChoice

    def get(self):
        htmlHead = "<!DOCTYPE html><html><head><title>Baseball</title></head>"
        htmlBody = "<body>"
        movie = self.getRandomMovie()
        movieTomorrow = self.getRandomMovie()
        htmlFoot = "</body></html>"

        # make sure tomorrow's movie is not today's movie
        while movie == movieTomorrow:
            movieTomorrow = self.getRandomMovie()

        # build the response string
        response = "<h1>Movie of the Day</h1>"
        response += "<p>" + movie + "</p>"

        # TODO: pick a different random movie, and display it under
        # the heading "<h1>Tommorrow's Movie</h1>"
        responseTomorrow = "<h1>Tommorrow's Movie</h1>"
        responseTomorrow += "<p>" + movieTomorrow + "</p>"

        # display
        self.response.write(htmlHead)
        self.response.write(htmlBody)
        self.response.write(response)
        self.response.write(responseTomorrow)
        self.response.write(htmlFoot)

app = webapp2.WSGIApplication([
    ('/', Index)
], debug=True)
