const AccessTokenKey = 'entfrm_access_token'
const RefreshTokenKey = 'entfrm_refresh_token'

export function getAccessToken() {
  return uni.getStorageSync(AccessTokenKey)
}

export function setAccessToken(token) {
  return uni.setStorageSync(AccessTokenKey, token)
}

export function removeAccessToken() {
  return uni.setStorageSync(AccessTokenKey, "")
}

export function getRefreshToken() {
  return uni.getStorageSync(RefreshTokenKey)
}

export function setRefreshToken(token) {
  return uni.setStorageSync(RefreshTokenKey, token)
}

export function removeRefreshToken() {
  return uni.setStorageSync(RefreshTokenKey, "")
}
