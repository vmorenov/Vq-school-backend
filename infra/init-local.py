"""Generate local-only secrets once. Never overwrite an existing environment."""
from pathlib import Path
import secrets, os
target=Path(__file__).resolve().parent/'.env'
if target.exists():
    print('infra/.env already exists; preserved.')
else:
    values={key:secrets.token_hex(24) for key in ['VQ_BFF_SECRET','KEYCLOAK_ADMIN_PASSWORD','POSTGRES_PASSWORD','DEMO_STUDENT_PASSWORD']}
    values['FRONTEND_PATH']='../../Va-school-app'
    fd=os.open(target,os.O_WRONLY|os.O_CREAT|os.O_EXCL,0o600)
    with os.fdopen(fd,'w') as stream: stream.write(''.join(f'{k}={v}\n' for k,v in values.items()))
    print('Created infra/.env with local random secrets. Read it only on your own machine.')
