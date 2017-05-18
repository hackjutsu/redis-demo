import redis
r = redis.StrictRedis(host='localhost', port=6379, db=0)

r.set('foo', 'bar')
r.get('foo')

exp = 10
r.setex('foo_exp', exp, 'bar_exp')