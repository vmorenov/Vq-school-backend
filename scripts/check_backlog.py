"""Validate functional traceability without treating frontend tasks as extra scope."""
from pathlib import Path
import json

root=Path(__file__).resolve().parents[1]
data=json.loads((root/'docs/backlog.json').read_text())
stories={s['id']:s for s in data['stories']}
assert len(stories)==len(data['stories'])==40
assert sum(s['points'] for s in stories.values())==207
seen=set();active=set()
def visit(key):
    assert key in stories, f'Unknown dependency {key}'
    assert key not in active, f'Dependency cycle {key}'
    if key in seen:return
    active.add(key)
    for dependency in stories[key]['dependencies']:visit(dependency)
    active.remove(key);seen.add(key)
for key,s in stories.items():
    visit(key)
    assert s['issue_url'].startswith('https://github.com/vmorenov/Vq-school-backend/issues/')
    for task in s['frontend_tasks']:
        assert task['id'].startswith('FE-')
        assert task['url'].startswith('https://github.com/vmorenov/Va-school-app/issues/')
assert len({t['id'] for s in stories.values() for t in s['frontend_tasks']})==18
print('40 functional stories, 18 frontend tasks, valid links and acyclic dependencies.')
