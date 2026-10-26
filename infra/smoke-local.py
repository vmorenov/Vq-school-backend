"""Read-only smoke checks. Login/SSO must also be validated in a browser."""
from urllib.request import urlopen
from urllib.error import HTTPError
import json, time
base='http://localhost:8080'
def get(path):
    with urlopen(base+path,timeout=10) as r: return r.read()
for attempt in range(30):
    try:
        assert json.loads(get('/api/v1/session'))['authenticated'] is False
        break
    except Exception:
        if attempt==29: raise
        time.sleep(2)
for path in ['/mfe/academic/remoteEntry.js','/mfe/learning/remoteEntry.js','/public/']:
    assert get(path),path
assert json.loads(get('/auth/realms/vq-school/.well-known/openid-configuration'))['issuer']==base+'/auth/realms/vq-school'
try:
    get('/api/v1/platform/school')
    raise AssertionError('Unauthenticated access was accepted')
except HTTPError as error:
    assert error.code==401,error.code
print('Local anonymous smoke checks passed; complete login/logout acceptance separately.')
