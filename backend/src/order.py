from flask import jsonify
from base import session_factory
from .decorators import error_handler
from db.schemas.order import Order, OrderSchema

@error_handler
def get_orders(request):
    # todo: Use url query params to filter in db query
    session = session_factory()
    order_objects = session.query(Order).all()
    schema = OrderSchema(many=True)
    orders = schema.dump(order_objects)[0] # todo: lookup why schema dump is returning an extra empty array
    session.close()
    return (jsonify(orders), 200)

@error_handler
def get_order(request, id):
    session = session_factory()
    order_object = session.query(Order).get(id)
    schema = OrderSchema()
    order = schema.dump(order_object)[0] # todo: lookup why schema dump is returning an extra empty array
    session.close()
    return (jsonify(order), 200)