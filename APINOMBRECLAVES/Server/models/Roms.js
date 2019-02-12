const mongoose = require('mongoose');
const Schema = mongoose.Schema;
const roomSchema = Schema({
    name : String,
    freespaces : String,
    created_at: String,
    state: false
});

mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost:27017/nombreclave');

module.exports = mongoose.model('rooms', roomSchema);
