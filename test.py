import os
import git
import shutil
import tempfile

t = tempfile.mkdtemp()
git.Repo.clone_from('git@github.com:vindesh/openapi-diff-local.git', t, branch='main', depth=1)
shutil.move(os.path.join(t, 'pom.xml'), '.')
shutil.rmtree(t)

