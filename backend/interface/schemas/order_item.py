from marshmallow import Schema, fields, post_dump
import sys
sys.path.insert(0, '../../')
from db.schemas.order_item import OrderItem
from interface.schemas.menu_item import MenuItemSchema

class OrderItemSchema(Schema):
    id = fields.Integer(dump_only=True, required=True)
    slot = fields.Int()
    price = fields.Float(required=True)
    status = fields.Str(required=True)
    menu_item = fields.Nested(MenuItemSchema, required=True)
    menu_item_id = fields.Integer(dump_only=True, required=True)
    order_id = fields.Integer(dump_only=True, required=True)
    date_created = fields.DateTime(dump_only=True, required=True)
    date_modified = fields.DateTime(dump_only=True, required=True)

    @post_dump
    def remove_enum_prefix(self, out_data):
        out_data["status"] = out_data["status"].replace("OrderItemStatus.","")
        return out_data