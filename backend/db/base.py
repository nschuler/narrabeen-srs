from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

engine = create_engine('sqlite:///narrabeen2.db')
_SessionFactory = sessionmaker(bind=engine)

Base = declarative_base()

# Use session_factory() to get a new Session
def session_factory():
    Base.metadata.create_all(engine)
    return _SessionFactory()