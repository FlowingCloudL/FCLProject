local key_item = KEYS[1]
local key_user = KEYS[2]
local item_id = ARGV[1]

local item_exists = redis.call('exists', key_item)
if item_exists == 0 then
    return 0
end

local user_exists = redis.call('hexists', key_user, item_id)
if user_exists == 1 then
    local cnt = redis.call('hget', key_user, item_id)
    local limit = redis.call('hget', key_item, 'limit')
    if cnt >= limit then
        return 1
    end
end
local stock = tonumber(redis.call('hget', key_item, 'stock'))
if stock <= 0 then
    return 2
else
    redis.call('hincrby', key_user, item_id, 1)
    redis.call('hincrby', key_item, 'stock', -1)
    return 3
end
