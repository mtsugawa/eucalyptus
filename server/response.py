# a wrapper object for json responses to the browser

class Response(object):
    results = None

    def __init__(self, results):
        self.results = results

class ClcError(object):
    status = None
    summary = None
    message = None

    def __init__(self, status, summary, message):
        self.status = status
        self.summary = summary
        self.message = message
