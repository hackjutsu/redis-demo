# Redis Demo

Install redis
```bash
brew install redis
```

Launch redis server
```bash
redis-server ./redis.config
# Or
redis-server --daemonize yes
```

Verify the redis server is working
```bash
redis-cli ping
# PONG
```

Shut down the redis server
```bash
redis-cli shutdown
```

## License
MIT