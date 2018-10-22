from flask import Flask,render_template
from flask_sqlalchemy import SQLAlchemy
from flask_debugtoolbar import DebugToolbarExtension

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI']= "mysql+mysqldb://converse:converse@localhost/converse"
db = SQLAlchemy(app)
app.debug = True
app.config['SECRET_KEY']= 'sms-magic'
toolbar = DebugToolbarExtension(app)

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(80), unique=True, nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)

    def __repr__(self):
        return '<User %r>' % self.username

@app.route("/")
def home():
    return render_template("index.html")

if __name__=="__main__":
    app.run()

